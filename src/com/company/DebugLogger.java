package com.company;

import javax.swing.*;
import java.util.List;

/**
 * This allow use JTextArea for sending any debug info
 */

public class DebugLogger {
    private JTextArea debugArea;

    DebugLogger(JTextArea debugArea) {
        if (debugArea != null) {
            this.debugArea = debugArea;
            clearArea();
        } else throw new NullPointerException("JTextArea is'n initialized");
    }

    /**
     * Will append text string to area
     *
     * @param string with text
     */

    public void write(String string) {
        debugArea.append(string);
    }

    /**
     * Will append text string and line break after
     *
     * @param string with text
     */

    public void writeLine(String string) {
        debugArea.append(string + "\n");
    }

    /**
     * Will append empty line after last line
     */

    public void separate() {
        String areaText = debugArea.getText();
        if (areaText.toCharArray()[areaText.length() - 1] == '\n') {
            debugArea.append("\n");
        } else {
            debugArea.append("\n\n");
        }
    }

    /**
     * Will clear area without saving any data
     */

    public void clear() {
        debugArea.setText("");
    }

    /**
     * Will write one-dimensional array of int as text string with separating after
     *
     * @param array (one-dimensional array of int)
     */
    public void writeSingleArrayInt(int[] array) {
        for (int element : array) {
            write(String.valueOf(element) + " ");
        }
    }

    /**
     * Will write two-dimensional array of int as text string with separating after every line and after all
     *
     * @param array (two-dimensional array of int)
     */
    public void writeDoubleArrayInt(int[][] array) {
        for (int[] singleArray : array) {
            writeSingleArrayInt(singleArray);
            write("\n");
        }
        separate();
    }

    /**
     * Will serialize cyclePath in string
     *
     * @param list, every element is int[2]
     */
    public void writePath(List<int[]> list) {
        write("(");
        for (int[] element : list) {
            write(" [" + element[0] + ", " + element[1] + "] ");
        }
        write(")");
    }

    /**
     * Will clear debug area
     */
    public void clearArea() {
        debugArea.setText("");
    }
}
