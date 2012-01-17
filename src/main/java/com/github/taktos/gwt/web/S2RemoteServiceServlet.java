/**
 *
 */
package com.github.taktos.gwt.web;

import org.seasar.framework.container.SingletonS2Container;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * @author taktos
 *
 */
public class S2RemoteServiceServlet extends RemoteServiceServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public String processCall(String payload) throws SerializationException {
	    // First, check for possible XSRF situation
	    checkPermutationStrongName();

	    try {
	      RPCRequest rpcRequest = RPC.decodeRequest(payload, null, this);
	      onAfterRequestDeserialized(rpcRequest);
	      Object delegate = getServiceComponent(rpcRequest.getMethod().getDeclaringClass());

	      return RPC.invokeAndEncodeResponse(delegate, rpcRequest.getMethod(),
	          rpcRequest.getParameters(), rpcRequest.getSerializationPolicy(),
	          rpcRequest.getFlags());
	    } catch (IncompatibleRemoteServiceException ex) {
	      log(
	          "An IncompatibleRemoteServiceException was thrown while processing this call.",
	          ex);
	      return RPC.encodeResponseForFailure(null, ex);
	    } catch (RpcTokenException tokenException) {
	      log("An RpcTokenException was thrown while processing this call.",
	          tokenException);
	      return RPC.encodeResponseForFailure(null, tokenException);
	    }
	}

	protected <T> T getServiceComponent(Class<T> serviceClass) {
		T component = SingletonS2Container.getComponent(serviceClass);
		return component;
	}
}
