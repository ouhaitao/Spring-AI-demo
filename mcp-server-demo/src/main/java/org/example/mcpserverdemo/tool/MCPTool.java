package org.example.mcpserverdemo.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

/**
 * @author parry 2025/05/22
 */
@Service
public class MCPTool {
 
    @Tool(description = "获取城市的天气")
    public String getWeather(
        @ToolParam(description = "城市的名字") String city) {
        return city + "天气为晴天";
    }
}
