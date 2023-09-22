# gRPC - Communication Pattern
## Links
#### Communication Patterns
https://thenewstack.io/grpc-a-deep-dive-into-the-communication-pattern/

#### Simple RPC Tutorial
https://www.baeldung.com/grpc-introduction

# Summary
#### (a) client
Grpc Client to connect to the server

#### (b) server
Run Grpc Server on a port

#### (c) common
/proto stores the .proto files shared by client and server

## Steps
#### 1. mvn clean install
Generate Java files for the .proto definitions with "protobuf-maven-plugin" 

#### 2. Start Server

#### 3. Start Client

## Knowledge
#### (a)

#### (b) 

## Debug
#### (a) "No functional channel service provider found"
import grpc-netty

#### (b) 