import exception.ServerException;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class TestServer {

    final File FILE_IMPORT = new File("importDataFile.txt");
    final File FILE_EXPORT = new File("exportDataFile.txt");

    // Пытаемся запустить сервер и передаем NULL
    @Test
    public void startServerNullException() throws IOException, ServerException {
        if (Server.isIsStarted()) Server.stopServer(FILE_EXPORT);
        Server.startServer(null);
        Assert.assertTrue(Server.isIsStarted());
    }

    // Пытаемся дважды остановить сервер и проверяем, что throws ServerException
    @Test(expected = ServerException.class)
    public void stopServerException() throws IOException, ServerException {
        Server.stopServer(FILE_EXPORT);
        Server.stopServer(FILE_EXPORT);
    }

    // Пытаемся остановить сервер и передаем NULL в качества файла для сохранения и проверяем, что throws ServerException
    @Test(expected = ServerException.class)
    public void stopServerNullException() throws IOException, ServerException {
        if (!Server.isIsStarted()) Server.startServer(FILE_IMPORT);
        Server.stopServer(null);
    }

}
