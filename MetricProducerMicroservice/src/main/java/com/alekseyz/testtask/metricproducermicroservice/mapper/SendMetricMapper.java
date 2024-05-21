package com.alekseyz.testtask.metricproducermicroservice.mapper;

import com.alekseyz.testtask.metricproducermicroservice.dto.SendMetricDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SendMetricMapper implements Mapper<SendMetricDto, List<String>> {

    @Override
    public List<String> map(SendMetricDto sendMetricDto) {

       return Arrays.asList(
                sendMetricDto.getSource(),
                sendMetricDto.getMetricType(),
                sendMetricDto.getMetricName(),
                sendMetricDto.getMetricValue(),
                String.valueOf(sendMetricDto.getTimestamp())


        );
    }
}
