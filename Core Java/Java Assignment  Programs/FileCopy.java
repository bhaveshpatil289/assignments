package com.wipro.Assignments;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileCopy {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("/home/rps/wipro2024fsd/input.txt");
        Path destinationPath = Paths.get("/home/rps/wipro2024fsd/filecopied.txt");

        try (FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
             FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.CREATE,
                     StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (sourceChannel.read(buffer) != -1) {
                buffer.flip(); // flip the buffer to prepare for reading
                destinationChannel.write(buffer); // write from buffer to destination channel
                buffer.clear(); // clear the buffer for next read
            }

            System.out.println("Content copied from source file to destination file.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}




