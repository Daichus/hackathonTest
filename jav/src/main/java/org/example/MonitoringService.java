package org.example;

import java.util.Timer;
import java.util.TimerTask;

/**
 * MonitoringService 負責監控系統的運行狀況。
 * 這個類別會定期檢查系統的資源使用情況，並觸發告警。
 */
public class MonitoringService {

    private Timer timer;

    // 啟動監控服務
    public void startMonitoring() {
        timer = new Timer();
        timer.schedule(new MonitorTask(), 0, 5000); // 每 5 秒執行一次
        System.out.println("系統監控服務已啟動...");
    }

    // 停止監控服務
    public void stopMonitoring() {
        if (timer != null) {
            timer.cancel();
            System.out.println("系統監控服務已停止...");
        }
    }

    // 內部類別，用於執行監控任務
    private class MonitorTask extends TimerTask {
        @Override
        public void run() {
            // 這裡可以整合 Prometheus、Grafana 等監控工具來收集和檢查系統資料
            System.out.println("執行系統監控...");
            // 假設檢查 CPU、記憶體等資源使用情況
        }
    }
}