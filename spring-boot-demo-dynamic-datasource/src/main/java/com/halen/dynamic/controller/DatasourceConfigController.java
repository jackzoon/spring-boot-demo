package com.halen.dynamic.controller;

import com.halen.dynamic.annotation.DefaultDatasource;
import com.halen.dynamic.datasouce.DatasourceConfigCache;
import com.halen.dynamic.mapper.DatasourceConfigMapper;
import com.halen.dynamic.model.DatasourceConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DatasourceConfigController {
    private final DatasourceConfigMapper configMapper;
    @PostMapping("/config")
    @DefaultDatasource
    public DatasourceConfig insertConfig(@RequestBody DatasourceConfig datasourceConfig) {
        configMapper.insertUseGeneratedKeys(datasourceConfig);
        DatasourceConfigCache.INSTANCE.addConfig(datasourceConfig.getId(), datasourceConfig);
        return datasourceConfig;
    }

    @DeleteMapping("/config/{id}")
    @DefaultDatasource
    public void removeConfig(@PathVariable Long id) {
        configMapper.deleteByPrimaryKey(id);
        DatasourceConfigCache.INSTANCE.removeConfig(id);
    }
}
