package backend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UtisTest {

    Utis utis = null;
    String noFacilitado;
    String above;
    String below;
    ArrayList<GeoIP> list = null;

    @Before
    public void setUp() throws Exception {
        utis = new Utis();
        noFacilitado = "";
        above = "255.255.255.260";
        below = "0.0.0.-1";
        list = utis.getFile();
    }

    @After
    public void tearDown() throws Exception {
    }

    //Probar que no se introduce una IP p IP VACIA
    @Test(expected = Exception.class)
    public void localizaIP() throws Exception{
        utis.locateIP(noFacilitado, list);
    }

    @Test(expected = Exception.class)
    public void paramAbove()throws Exception{
        utis.locateIP(above, list);
    }

    @Test(expected = Exception.class)
    public void paramBelow()throws Exception{
        utis.locateIP(below, list);
    }
}