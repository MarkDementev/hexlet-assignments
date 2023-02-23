package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection implements Connection {
    private Connection connectionStatus;
    private String iP;
    private int port;
    private String textBuffer;

    public TcpConnection(String iP, int port) {
        this.iP = iP;
        this.port = port;
        this.connectionStatus = new Disconnected(this);
    }

    @Override
    public String getCurrentState() {
        return connectionStatus.getCurrentState();
    }

    @Override
    public void connect() {
        connectionStatus.connect();
    }

    @Override
    public void disconnect() {
        this.connectionStatus.disconnect();
    }

    @Override
    public void write(String textToBuffer) {
        this.connectionStatus.write(textToBuffer);
    }

    public void setConnectionStatus(Connection settingConnection) {
        this.connectionStatus = settingConnection;
    }

    public void setTextBuffer(String textToBuffer) {
        this.textBuffer = textToBuffer;
    }
}
// END
