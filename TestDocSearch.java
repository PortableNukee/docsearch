import static org.junit.Assert.*;
import java.io.File;
import org.junit.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class TestDocSearch {
	@Test 
	public void testIndex() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/");
    assertEquals("There are 1391 total files to search.", h.handleRequest(rootPath));
	}
	@Test 
	public void testSearch() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    String sep = File.separator;
    URI rootPath = new URI("http://localhost/search?q=Resonance");
    String expect = String.format("Found 2 paths:\n.%stechnical%sbiomed%sar615.txt\n.%stechnical%splos%sjournal.pbio.0020150.txt", sep, sep, sep, sep, sep, sep);
    assertEquals(expect, h.handleRequest(rootPath));
	}
    @Test 
	public void testSearch2() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/search?q=dhakshbnfilanifohaiodaklmdla");
        assertEquals("Found 0 paths:\n", h.handleRequest(rootPath));
	}
    @Test
    public void testSearch3() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        String sep = File.separator;
        URI rootPath = new URI("http://localhost/search?q=peanut");
        String expect = String.format("Found 3 paths:\n.%stechnical%sbiomed%s1471-2229-3-3.txt\n.%stechnical%sbiomed%s1477-7827-1-43.txt\n.%stechnical%sgovernment%sEnv_Prot_Agen%stech_adden.txt", sep, sep, sep, sep, sep, sep,sep,sep,sep,sep,sep,sep,sep);
        assertEquals(expect, h.handleRequest(rootPath));
	}
    
}

