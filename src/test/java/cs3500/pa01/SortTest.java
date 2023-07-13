package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;



/**
 * Sort tester class to test sorting, outputting, and writing to a file.
 */
class SortTest {

  /**
   * tests sorting with a given flag.
   */
  @Test
  void sort() {
    MarkdownFile mdf1 = new MarkdownFile();
    MarkdownFile mdf2 = new MarkdownFile();
    MarkdownFile mdf3 = new MarkdownFile();
    mdf1.filename = "B";
    mdf2.filename = "C";
    mdf3.filename = "A";

    ArrayList<MarkdownFile> Amdf = new ArrayList<MarkdownFile>();
    Amdf.add(mdf1);
    Amdf.add(mdf2);
    Amdf.add(mdf3);
    Amdf.sort(new FilenameCompare());
    assertEquals(Amdf.get(0), mdf3);
    assertEquals(Amdf.get(1), mdf1);
    assertEquals(Amdf.get(2), mdf2);
  }

  /**
   * Tests outputting string to a file method.
   */
  @Test
  void outputFile() throws IOException {
    MarkdownFile mdf = new MarkdownFile();
    Flag flag = Flag.FILENAME;
    ArrayList<MarkdownFile> Amdf = new ArrayList<MarkdownFile>();
    mdf.contents = "- [[This is a string to output to a given file]]\n";
    Path path1 = Path.of("src", "test", "resources",
        "dummyMdFolder", "output.md");
    Amdf.add(mdf);
    Sort sortedList = new Sort(Amdf, flag);
    sortedList.outputFile(path1);
    Scanner sc = new Scanner(path1);
    String strBuilder = null;
    while (sc.hasNextLine()) {
      strBuilder = sc.nextLine();
    }
    assertEquals(strBuilder, "- [[This is a string to output to a given file]]");


  }

  /**
   * Tests writing to a file.
   */
  @Test
  void writeToFile() {
  }
}