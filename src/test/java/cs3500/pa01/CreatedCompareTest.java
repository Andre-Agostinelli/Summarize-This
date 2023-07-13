package cs3500.pa01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * Testing the CreatedCompare Class
 */
class CreatedCompareTest {

  /**
   * Testing the compare function to it returns based on Time Created.
   */
  @Test
  void compare() throws IOException {
    MarkdownFile mdf1 = new MarkdownFile();
    MarkdownFile mdf2 = new MarkdownFile();
    mdf1.path = Path.of("CS3500", "pa01-Andre-Agostinelli", "dummymarkdown1");
    System.out.println(mdf1.path);
    mdf2.path = Path.of("CS3500, pa01-Andre-Agostinelli, dummymarkdown2");

    //mdf1.fillMarkdownFile(mdf1.path, BasicFileAttributes);
  }

}