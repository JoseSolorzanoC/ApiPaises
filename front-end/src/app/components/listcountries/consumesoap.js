function run(){
  var webServiceURL = 'http://localhost:8080/ws/country/countries.wsdl';
  var soapMessage = '<soap12:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://www.w3.org/2003/05/soap-envelope"><soap12:Body><getAllCountries xmlns="http://tempuri.org/" /></soap12:Body></soap12:Envelope';

  function CallService()
  {
      $.ajax({
        url: webServiceURL,
        type: "GET",
        dataType: "xml",
        data: soapMessage,
        processData: false,
        contentType: "text/xml; charset=\"utf-8\"",
        success: OnSuccess,
        error: OnError
      });

      return false;
  }

  function OnSuccess(data, status)
  {
      alert(data.d);
  }

  function OnError(request, status, error)
  {
      alert('error');
  }

  $(document).ready(function() {
      jQuery.support.cors = true;
  });
}
