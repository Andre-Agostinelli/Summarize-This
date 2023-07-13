package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/*
@author Andre Agostinelli;
@version v1
@since 2015-09-22

 */

/**
 * This is the main driver of this project.
 * Aims to instantiate needed objects and call methods.
 */
public class Driver {
  /**
   * Project entry point.
   *
   * @param args - String[2] = args[0] String startingDir, args[1] String flag,
   *             args[2] String outputDir
   *             Path startingDir, Flag flag, Path outputDir.
   */
  public static void main(String[] args) {
    System.out.println("Utilizing the cmd-line argument "
        + "input file path to determine where to start...");
    Path startingDir = Path.of(args[0]);
    Flag f = switch (args[1]) {
      case "filename" -> Flag.FILENAME;
      case "modified" -> Flag.MODIFIED;
      case "created" -> Flag.CREATED;
      default -> throw new RuntimeException("String for sorting flag is invalid: " + args[1]);
    };

    Path outputDir = Path.of(args[2]);

    FileExplorer fileExp = new FileExplorer(new ArrayList<>());
    try {
      //walks the file tree
      Files.walkFileTree(startingDir, fileExp);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    Sort sortedList = new Sort(fileExp.mdCollection, f);
    sortedList.outputFile(outputDir);
  }
}