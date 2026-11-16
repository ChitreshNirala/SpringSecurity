# Change Log

## Summary
This repository contains multiple independent Spring Security sample modules under separate folders. It did not have a root Maven `pom.xml`, which prevented the project from being compiled as a single repository-level build.

## Change made
- Added a root Maven aggregator file at `pom.xml`.
- Included all Spring Security modules as Maven modules so they can be built together from the repository root.

## Reason for change
The project previously only had individual `pom.xml` files inside each module directory. Without a parent/root Maven configuration, build tooling could not resolve the repository as a single project and the compilation problem occurred when attempting to build from the top-level directory.

## File added
- `pom.xml`

## Validation
The repository-level Maven build was validated with:

```bash
mvn -q test --file pom.xml
```

This completed successfully.
