public class Convertir 
{
    public static ByteBuffer objToBBuffer (Object o) throws IOException
    {
        ObjectOutputStream os;
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        os = new ObjectOutputStream(bs);
        os.writeObject(o);
        ByteBuffer buff = ByteBuffer.allocate(bs.size());
        buff.put(bs.toByteArray());
        
        return buff;
    }
    //a la espera del mètode que m'ha de passar el Marcel per si aquest no és correcte
    public static Object BBufferToObj (ByteBuffer bb) throws IOException, ClassNotFoundException
    {
        ObjectInputStream os;
        byte [] bArray = new byte[bb.limit()];
        bb.flip();
        bb.get(bArray);
        
        ByteArrayInputStream bs = new ByteArrayInputStream(bArray);
        os = new ObjectInputStream(bs);
        Object o = os.readObject();
        
        return o;
        
    }
}
