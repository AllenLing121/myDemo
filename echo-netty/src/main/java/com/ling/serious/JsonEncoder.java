package com.ling.serious;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by Lian on 04/01/2019.
 */
public class JsonEncoder extends MessageToByteEncoder<Object> {
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf out) throws Exception {
        byte [] data = JSONObject.toJSONString(o).getBytes();
        out.writeBytes(data);
    }

}
