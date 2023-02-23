package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection{
    private TcpConnection tCPConnection;
    private final String connectionTypeString = "connected";

    public Connected(TcpConnection tCPConnection) {
        this.tCPConnection = tCPConnection;
    }
    //done
    @Override
    public String getCurrentState() {
        return connectionTypeString;
    }
    //done
    @Override
    public void connect() {
        System.out.println("Error! Connection already connected");
    }
    //done
    @Override
    public void disconnect() {
        this.tCPConnection.setConnectionStatus(new Disconnected(this.tCPConnection));
    }
    //done
    @Override
    public void write(String textToBuffer) {
        this.tCPConnection.setTextBuffer(textToBuffer);
    }
}
// END
