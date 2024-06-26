package User;

import com.demo.grpc.User.APIResponse;
import com.demo.grpc.User.Empty;
import com.demo.grpc.User.LoginRequest;
import com.demo.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {

		System.out.println("Inside login");

		String username = request.getUsername();
		String password = request.getPassword();

		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {

			 // return success message

			response.setResponseCode(0).setResponsemessage("SUCCESS");

		}
		else {
			response.setResponseCode(100).setResponsemessage("INVALID PASSWORD");
		}



		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {

	}
	
	/*
	 * @Override public void registerUser(User request, StreamObserver<UserResponse>
	 * responseObserver) { // Implement user registration logic here String message
	 * = "User registered successfully: " + request.getUsername(); UserResponse
	 * response = UserResponse.newBuilder().setMessage(message).build();
	 * responseObserver.onNext(response); responseObserver.onCompleted(); }
	 */



}