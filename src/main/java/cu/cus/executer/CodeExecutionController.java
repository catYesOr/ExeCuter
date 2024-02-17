package cu.cus.executer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

@RestController
public class CodeExecutionController {

    @PostMapping("/run")
    public ResponseEntity<?> executeCode(@RequestBody CodeRequest codeRequest) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // Предполагается, что в codeRequest.code содержится полный код Java класса
        Path sourcePath = Paths.get("TempSource.java");
        try {
            // Записываем код во временный файл
            Files.writeString(sourcePath, codeRequest.getCode());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);

            // Компиляция класса
            compiler.run(null, ps, ps, sourcePath.toString());

            // Загрузка и выполнение скомпилированного класса (предполагается, что класс содержит метод main)
            ProcessBuilder pb = new ProcessBuilder("java", "TempSource");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            // Чтение stdout и stderr от запущенного процесса
            String output = new String(process.getInputStream().readAllBytes());

            // Удаление временного файла с исходным кодом и скомпилированным классом
            Files.delete(sourcePath);
//            Files.delete(Paths.get("TempSource.class"));

            return ResponseEntity.ok(new CodeResponse(output));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Ошибка выполнения кода");
        }
    }

    static class CodeRequest {
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    static class CodeResponse {
        private String output;

        public CodeResponse(String output) {
            this.output = output;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }
    }
}
