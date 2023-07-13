package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * MarkdownFile test to run on markdownFile
 */
class MarkdownFileTest {

  /**
   * Sets up the markdownFil creation
   */
  @BeforeEach
  void createMdFile() {
    //MarkdownFile mdf = new MarkdownFile();
  }

  /**
   * Tests the transform function to wanted string output
   */
  @Test
  void transform() {
    //Test with a line break in bullet to reach this case
    // Both have headers to ensure they are tested as well
    MarkdownFile mdf = new MarkdownFile();
    mdf.contents = "# My name is Andre\n\n## Your BOB \n- [[I Like\n Pie]]";
    String answer = "# My name is Andre\n\n## Your BOB \n- I Like Pie\n";
    String str1 = mdf.transform(mdf.contents);
    assertEquals(str1, answer);

    //Test to see without a line break to reach that case
    MarkdownFile mdf1 = new MarkdownFile();
    mdf1.contents = "# My name is Andre\n\n## Your BOB \n- [[I Like Pie]]";
    String str2 = mdf.transform(mdf.contents);
    assertEquals(str2, answer);
  }

  /**
   * Tests the fillMarkdownFile to see if fields are properly initiated
   */
  @Test
  void fillMarkdownFile() throws IOException {

    BasicFileAttributes attr = Files.readAttributes(Path.of("src", "test", "resources",
        "dummyMdFolder", "sampleMarkdown.md"),  BasicFileAttributes.class);
    MarkdownFile mdf = new MarkdownFile();
    mdf.fillMarkdownFile(Path.of("src", "test", "resources",
        "dummyMdFolder", "sampleMarkdown.md"), attr, "- [[abcdef]]");
    assertEquals(mdf.contents, "- abcdef\n");
    //MarkdownFile mdf = new MarkdownFile();
    //Path samplePath;
    //mdf.fillMarkdownFile();
  }
}
