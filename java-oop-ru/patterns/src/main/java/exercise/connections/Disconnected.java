package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection tCPConnection;
    private final String connectionTypeString = "disconnected";

    public Disconnected(TcpConnection tCPConnection) {
        this.tCPConnection = tCPConnection;
    }

    @Override
    public String getCurrentState() {
        return connectionTypeString;
    }

    @Override
    public void connect() {
        this.tCPConnection.setConnectionStatus(new Connected(this.tCPConnection));
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Connection already disconnected");
    }

    @Override
    public void write(String textToBuffer) {
        System.out.println("Error! Connection already disconnected");
    }
}
// END
