kubectl delete -f Deployment-Postgresql.yml
kubectl delete -f Service-Postgresql.yml
kubectl delete -f Deployment-PersonApi.yml
kubectl delete -f Service-PersonApi.yml
kubectl delete -f Ingress-Person-Api.yml