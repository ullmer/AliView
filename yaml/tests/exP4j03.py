from py4j.java_gateway import JavaGateway, GatewayParameters

gwparam = GatewayParameters(address='127.0.0.1', port=25333)
gw = JavaGateway(gateway_parameters=gwparam)
rc = gw.entry_point

#rc.getAlignment().getSequences().get(0)
#print(dir(rc.getAlignment()))
print(dir(rc.getAlignment().getSequences()))

#.getSequences().get(0)

