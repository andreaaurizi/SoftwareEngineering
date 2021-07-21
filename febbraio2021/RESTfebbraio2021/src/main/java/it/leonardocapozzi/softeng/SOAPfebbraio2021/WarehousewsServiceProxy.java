package it.leonardocapozzi.softeng.SOAPfebbraio2021;

public class WarehousewsServiceProxy implements it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsService {
  private String _endpoint = null;
  private it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsService warehousewsService = null;
  
  public WarehousewsServiceProxy() {
    _initWarehousewsServiceProxy();
  }
  
  public WarehousewsServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initWarehousewsServiceProxy();
  }
  
  private void _initWarehousewsServiceProxy() {
    try {
      warehousewsService = (new it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsServiceImplServiceLocator()).getWarehousewsServiceImplPort();
      if (warehousewsService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)warehousewsService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)warehousewsService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (warehousewsService != null)
      ((javax.xml.rpc.Stub)warehousewsService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsService getWarehousewsService() {
    if (warehousewsService == null)
      _initWarehousewsServiceProxy();
    return warehousewsService;
  }
  
  public it.leonardocapozzi.softeng.SOAPfebbraio2021.DetailsImpl getDetails(int arg0) throws java.rmi.RemoteException{
    if (warehousewsService == null)
      _initWarehousewsServiceProxy();
    return warehousewsService.getDetails(arg0);
  }
  
  
}