package com.threepounds.invoiceservice.controller;

import com.lowagie.text.DocumentException;
import com.threepounds.baseservice.shared.sharedorder.OrderResource;
import com.threepounds.baseservice.shared.sharedorder.SharedOrder;
import com.threepounds.baseservice.shared.sharedorder.SharedOrderService;
import com.threepounds.baseservice.stream.OrderCreatedMessage;
import com.threepounds.invoiceservice.pdf.PdfGenerator;
import com.threepounds.invoiceservice.util.S3Util;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
public class TestPdf {

    private static final String S3_BUCKET_INVOICE_FOLDER = "invoice/";
    private final SharedOrderService sharedOrderService;
    private final OrderResource orderResource;

    public TestPdf(SharedOrderService sharedOrderService, OrderResource orderResource) {
        this.sharedOrderService = sharedOrderService;
        this.orderResource = orderResource;
    }

    @RabbitListener(queues = {"q.order"})
    public void exportPdf(OrderCreatedMessage message) throws DocumentException, IOException {
        log.info("User Registration Event Received: {}", message);
//        response.setContentType("application/pdf");
//        response.setHeader("Content-Disposition", "attachment; file=invoice.pdf");
//        SharedOrder sharedOrder = sharedOrderService.getOrderById(id).getBody();
//        OrderResource orderResource = new OrderResource();
//        orderResource.setRestaurantName(sharedOrder.getSharedRestaurant().getName());
//        List<String> foodName = sharedOrder.getSharedFood().stream().map(s -> s.getName()).collect(Collectors.toList());
//        orderResource.setFoodName(foodName);
//        orderResource.setDate(sharedOrder.getCreatedDate().toString());
//        orderResource.setNote(sharedOrder.getNote());
//        orderResource.setName(sharedOrder.getSharedUser().getName());
//        orderResource.setPaymentType(sharedOrder.getPaymentType());
//        orderResource.setPrice(sharedOrder.getPrice().toString());
//        PdfGenerator.generate(response, orderResource);
//        UUID s3id = UUID.randomUUID();
//        String s3Id = s3id.toString();
//        System.out.println("s3Id");
//
//        try {
//            S3Util.uploadObject("microservice-training", S3_BUCKET_INVOICE_FOLDER + s3id + ".pdf",
//                    file.getInputStream());
//
//        } catch (IOException e) {
//            log.error("An error occured during file upload", e);
//        }
    }
}


