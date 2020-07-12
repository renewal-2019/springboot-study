package com.example.demo.service;

//@Service
//public class ResponseConventer extends AbstractHttpMessageConverter<AjaxResponse> {
//
//    //使响应中夹带请求头,告诉前端响应的是excel的格式
//    public static final MediaType EXCEL_TYPE = MediaType.valueOf("application/vnd.ms-excel");
//
//    ResponseConventer (){
//        super(EXCEL_TYPE);
//    }
//
//    @Override
//    protected boolean supports(Class<?> aClass) {
//        return aClass == AjaxResponse.class;
//    }
//
//    @Override
//    protected AjaxResponse readInternal(Class<? extends AjaxResponse> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
//        return null;
//    }
//
//    @Override
//    protected void writeInternal(AjaxResponse ajaxResponse, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
//
//        final Workbook workbook = new HSSFWorkbook();
//        final Sheet sheet = workbook.createSheet();
//
//        final Row row = sheet.createRow(0);
//        row.createCell(0).setCellValue(ajaxResponse.getMessage());
////        row.createCell(1).setCellValue(ajaxResponse.getObj().toString());
//
//        workbook.write(httpOutputMessage.getBody());
//
//    }
//}
