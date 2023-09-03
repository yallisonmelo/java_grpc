package br.com.yfsmsystem.service;

import br.com.yfsmsystem.grpcFortune.FortuneGrpc;
import br.com.yfsmsystem.grpcFortune.FortuneMessage;
import br.com.yfsmsystem.grpcFortune.FortuneReply;
import br.com.yfsmsystem.grpcFortune.FortuneRequest;
import io.grpc.stub.StreamObserver;


public class FortuneService  extends FortuneGrpc.FortuneImplBase {

    @Override
    public void callFortune (FortuneRequest request, StreamObserver<FortuneReply> responseObserver) {
        FortuneReply.Builder response = FortuneReply.newBuilder();

        String caller = request.getName();
        FortuneMessage fortuneMessage = new FortuneMessage();
        String resposta = caller +
                " : " +
                fortuneMessage.retornaFrase();
        response.setMessage(resposta);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
