# Server Configuration

> In this section, we will start the GemFire server using `gfsh` and `properties` file, and use `ClientCache` to access the locator
> and perform operations on the region.

# Program Description

## Server Side

- cluster/`gemfire.properties` file

> This file is used to start the server as specified,indicating the locator and `cache-xml-file`

- cluster/`cluster.xml` file

> The purpose of this cache-xml-file is to define the configuration for the Gemfire server's cache.
> Specifically, it sets up two regions, `Book` and `Customer`, with replication attributes.
> The `REPLICATE` attribute indicates that these regions will be fully replicated across all cache members,
> ensuring data redundancy and availability.

## Client Side

- resources/`gemfire.properties` file

> Used to specify the cache-xml-file

- resources/`clientCache.xml`

> This file defines the configuration for the Gemfire client cache, specifying how the client interacts with GemFire cluster.
> and the `<pool>` defines a connection pool that specifies how the client connects to the Gemfire server, it includes details
> like the locator's host and port, which help the client discover and connect the appropriate servers.
> Then `<region>` defines the regions that the client will interact with.

### Region `refid` Description

- PROXY
    - The client cache acts as a proxy, meaning it does not store data locally, all data operation are forwarded to the server.
    - When the client only needs to access data and does not need to cache data locally.
- LOCAL
    - The client cache stores data locally, this mode allows the client to maintain a local copy of the data, which can improve
    performance by reducing the need for frequent server communication.
    - When the client needs to cache data locally to enhance performance and reduce latency.
- CACHING_PROXY
    - The client cache stores a subset of data locally, and data that is not cached locally is requested form the server. It
    combines local caching with proxy functionality.
    - When the client needs to cache frequently accessed data locally while still relying on the server for other data.


# Operation
## Starting the Locator

```bash
$ cd cluster
$ gfsh
gfsh> start locator --name=locator
```

## Starting the Servers

```bash
gfsh> start server --name=server1 --server-port=0 --properties-file=gemfire.properties
gfsh> start server --name=server2 --server-port=0 --properties-file=gemfire.properties
gfsh> list members
gfsh> list regions
```

## Put Data into Region

```bash
$ cd 2-server-configuration
$ mvn test
```

## Shutdown system

```bash
$ gfsh
gfsh> connect
gfsh> shutdown --include-locators=true
```