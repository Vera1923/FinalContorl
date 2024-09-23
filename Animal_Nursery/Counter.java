public class Counter implements AutoCloseable{
    private int count;
    private boolean closed;

    public Counter (){
        this.count = 0;
        this.closed = false;
    }

    public void add() {
        if (closed) {
            throw new IllegalStateException("Счетчик не может быть использован.");
        }
        count++;
    }

    public int getCount(){
        if (closed) {
            throw new IllegalStateException("Счетчик закрыт.");
        }
        return count;
    }

    @Override
    public void close(){
        if (closed) {
            throw new IllegalStateException("Счетчик уже закрыт.");
        }
        closed = true;
    }
}
