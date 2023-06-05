package services;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class AuditService {
    FileWriter writer;

    public AuditService() {
        try {
            this.writer = new FileWriter("src/audit/logs.csv",true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addLog(String action) throws IOException {
        this.writer = new FileWriter("src/audit/logs.csv",true);
        long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);

        this.writer.write((action + ','+ timestamp + '\n'));
        this.writer.close();
    }
}