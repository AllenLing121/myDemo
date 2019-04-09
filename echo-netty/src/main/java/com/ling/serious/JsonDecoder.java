package com.ling.serious;

import com.alibaba.fastjson.JSON;
import com.ling.entity.Member;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * Created by Lian on 04/01/2019.
 */
public class JsonDecoder extends MessageToMessageDecoder<ByteBuf> {
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf msg, List list) throws Exception {
        int len = msg.readableBytes();
        byte [] data = new byte[len];
        msg.getBytes(msg.readerIndex(),data,0,len);
        list.add(JSON.parseObject(new String(data)).toJavaObject(Member.class));
    }
}
