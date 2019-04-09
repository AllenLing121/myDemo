package com.ling;

import com.ling.entity.Member;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.MessageSizeEstimator;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by Lian on 03/29/2019.
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            Member member = (Member)msg;
            System.out.println(member);
            member.setName("ECHO "+ member.getName());
            ctx.writeAndFlush(member);
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
