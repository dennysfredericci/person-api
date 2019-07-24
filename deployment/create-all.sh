kubectl create -f Deployment-Postgresql.yml
kubectl create -f Service-Postgresql.yml
kubectl create -f Deployment-PersonApi.yml
kubectl create -f Service-PersonApi.yml
kubectl create -f Ingress-Person-Api.yml