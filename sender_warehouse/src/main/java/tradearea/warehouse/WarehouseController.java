package tradearea.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import tradearea.model.WarehouseData;

import javax.jms.Queue;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService service;


    @RequestMapping("/")
    public String warehouseMain() {
        String mainPage = "This is the warehouse application! (DEZSYS_WAREHOUSE_REST) <br/><br/>" +
                "<a href='http://localhost:8081/warehouse/001/data'>Link to warehouse/001/data</a><br/>" +
                "<a href='http://localhost:8081/warehouse/001/xml'>Link to warehouse/001/xml</a><br/>" +
                "<a href='http://localhost:8081/warehouse/001/transfer'>Link to warehouse/001/transfer</a><br/>" +
                "<a href='http://localhost:8081/warehouse/001/send'>Senden</a>";
        return mainPage;
    }

    @RequestMapping(value="/warehouse/{inID}/data", produces = "application/json")
    public WarehouseData warehouseData(@PathVariable String inID) {
        return service.getWarehouseData(inID);
    }

    @RequestMapping(value="/warehouse/{inID}/xml", produces = "application/xml")
    public WarehouseData warehouseDataXML(@PathVariable String inID) {
        return service.getWarehouseData(inID);
    }

    @RequestMapping("/warehouse/{inID}/transfer")
    public String warehouseTransfer(@PathVariable String inID) {
        // Hier wird die Datenübertragung an die Zentrale implementiert
        String data = "Daten von Lagerstandort " + inID;
        return service.getGreetings("Warehouse.Transfer!");
    }

    @RequestMapping("/warehouse/{inID}/send")
    public String warehouseSend(@PathVariable String inID) {
        JmsSender sender = new JmsSender("warehouse");
        WarehouseData data = service.getWarehouseData(inID);
        sender.sendMessage(data);
        sender.stop();
        return "Data send";
    }
}
