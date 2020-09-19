package com.halen.dynamic;

import com.halen.dynamic.datasouce.DatasourceConfigCache;
import com.halen.dynamic.datasouce.DatasourceConfigContextHolder;
import com.halen.dynamic.mapper.DatasourceConfigMapper;
import com.halen.dynamic.model.DatasourceConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SpringBootDemoDynamicDatasourceApplication implements CommandLineRunner {

    private final DatasourceConfigMapper configMapper;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDynamicDatasourceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 设置默认的数据源
        DatasourceConfigContextHolder.setDefaultDatasource();
        // 查询所有数据库配置列表
        List<DatasourceConfig> datasourceConfigs = configMapper.selectAll();
        System.out.println("加载其余数据源配置列表: " + datasourceConfigs);
        // 将数据库配置加入缓存
        datasourceConfigs.forEach(config -> DatasourceConfigCache.INSTANCE.addConfig(config.getId(), config));
    }
}
