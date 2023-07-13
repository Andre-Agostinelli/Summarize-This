package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * Test to test whole program from the command line
 */
class DriverTest {

  /**
   * Tests the main function essentially from command line
   */
  @Test
  public void testMain() throws IOException {
    Path temp = Files.createTempDirectory("t");
    String[] args = {temp.toString(), "filename", "out.md"};
    Driver.main(args);
  }

}