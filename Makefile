tool:
	docker-compose \
		-f docker-compose-adminer.yml \
		-f docker-compose-mysql.yml \
		up -d

dev:
	./gradlew quarkusDev

build:
	docker build -f src/main/docker/Dockerfile.jvm -t quarkus/hobby-jvm . --no-cache

native-build:
	./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true && docker build -f src/main/docker/Dockerfile.native-distroless -t quarkus/hobby-native . --no-cache

prod:
	docker-compose \
		-f docker-compose-adminer.yml \
		-f docker-compose-mysql.yml \
		-f docker-compose.yml \
		up
