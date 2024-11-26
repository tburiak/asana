package org.tbur.utils;

import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileReader;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDataLoader {

    @Data
    public static class TestData {
        private String testCaseName;
        private String project;
        private String taskName;
        private String column;
        private List<String> tags;
    }

    public static List<TestData> loadTestData(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            TestData[] data = gson.fromJson(reader, TestData[].class);
            return List.of(data);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data", e);
        }
    }

}
