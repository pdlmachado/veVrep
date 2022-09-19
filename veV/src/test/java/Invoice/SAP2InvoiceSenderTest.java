package Invoice;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SAP2InvoiceSenderTest {

    private InvoiceFilter filter = mock(InvoiceFilter.class);
    private SAP2 sap = mock(SAP2.class);
    private SAP2InvoiceSender sender = new SAP2InvoiceSender(filter, sap);

    @ParameterizedTest
    @CsvSource({
            "Mauricio,Ma",
            "M,X"}
    )
    void sendToSapWithTheGeneratedId(String customer, String initialId) {
        Invoice mauricio = new Invoice(customer, 20);

        List<Invoice> invoices = Arrays.asList(mauricio);
        when(filter.lowValueInvoices()).thenReturn(invoices);

        sender.sendLowValuedInvoices();

        ArgumentCaptor<SapInvoice2> captor = ArgumentCaptor.forClass(SapInvoice2.class);
        verify(sap).send(captor.capture());

        SapInvoice2 generatedSapInvoice = captor.getValue();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MMddyyyy"));
        assertThat(generatedSapInvoice).isEqualTo(new SapInvoice(customer, 20, date + initialId));
    }


    @Test
    void oldExample() {
        Invoice mauricio = new Invoice("Mauricio", 20);

        List<Invoice> invoices = Arrays.asList(mauricio);
        when(filter.lowValueInvoices()).thenReturn(invoices);

        sender.sendLowValuedInvoices();

        verify(sap).send(any(SapInvoice2.class));
    }


}
