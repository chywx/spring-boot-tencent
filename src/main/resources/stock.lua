local stock = tonumber(redis.call("get", "goods:sum"));
if (stock > 0) then
    redis.call("decr", "goods:sum");
    return stock;
end
return 0;