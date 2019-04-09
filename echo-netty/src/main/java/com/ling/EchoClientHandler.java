package com.ling;

import com.ling.entity.Member;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.time.LocalDateTime;

/**
 * Created by Lian on 03/29/2019.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Member member = null;
        for (int i = 0; i <10; i++) {
           // String str = "Hello I'm Client."+ i + System.getProperty("line.separator");
            member = new Member(i+"","name"+i,22,32d, LocalDateTime.now());
            ctx.writeAndFlush(member);

        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            Member member =  (Member)msg ;
            System.out.println(member);
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
