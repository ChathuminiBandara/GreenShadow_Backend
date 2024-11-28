package com.example.demo.Service;

import com.example.demo.DTO.IMPL.MonitoringLogDTO;
import com.example.demo.DTO.MonitoringLogStatus;

import java.util.List;

public interface MonitoringLogService {
    void saveLog(MonitoringLogDTO monitoringLogDTO);
    List<MonitoringLogDTO> getAllLogs();
    MonitoringLogStatus getLog(String logCode);
    void deleteLog(String logCode);
    void updateLog(String logCode,MonitoringLogDTO monitoringLogDTO);
}
