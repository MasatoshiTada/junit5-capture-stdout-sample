package com.example;

import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 標準出力をキャプチャしてテストするリスナークラス
 */
public class StdoutListener implements TestExecutionListener {

    /**
     * 各テストメソッドのuniqueIdと期待結果を持つマップ
     */
    private static final Map<String, String> UNIQUE_ID_EXPECTED_PAIRS = Map.of(
            "[engine:junit-jupiter]/[class:com.example.MainTest]/[method:testMain1()]", "Hello!\n",
            "[engine:junit-jupiter]/[class:com.example.MainTest]/[method:testMain2()]", "Hello!\n",
            "[engine:junit-jupiter]/[class:com.example.MainTest]/[method:testMain3()]", "Hello, Alice!\n"
    );

    @Override
    public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry) {
        // 期待値を取得
        String uniqueId = testIdentifier.getUniqueId();
        String expectedStdout = UNIQUE_ID_EXPECTED_PAIRS.get(uniqueId);
        // 実際の標準出力結果を取得
        Map<String, String> keyValuePairs = entry.getKeyValuePairs();
        String actualStdout = keyValuePairs.get("stdout");
        // アサーション
        assertEquals(expectedStdout, actualStdout);
    }
}
