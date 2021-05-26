package com.alasdoo.developercourseassignment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;

import java.io.IOException;

public class TestTest {
    @Test
    public void whatever() throws IOException {
        System.out.println("Whatever");
        String[] args = new String[] {"/bin/bash", "-c", "cd","../../../../../frontend", "/node_modules/yarn/bin/yarn", "start"};
        Process proc = new ProcessBuilder(args).start();
    }
}
