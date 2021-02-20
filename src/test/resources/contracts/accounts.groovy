package contracts

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            request {
                method 'GET'
                url '/v1/accounts/1'
            }
            response {
                status 200
                body('{"id":1,"name":"My Checking","startingBalance":500.01,"currentBalance":8000.56,"isPrimary":true,"isInCashFlow":true,"type":{"id":1}}')
                headers {
                    contentType('application/json')
                }

            }
        },
        Contract.make {
            request {
                method 'GET'
                url '/v1/accounts/2'
            }
            response {
                status 200
                body('{"id":2,"name":"My Savings","startingBalance":100.34,"currentBalance":7000.21,"isPrimary":false,"isInCashFlow":true,"type":{"id":2}}')
                headers {
                    contentType('application/json')
                }

            }
        },
        Contract.make {
            request {
                method 'GET'
                url '/v1/accounts/3'
            }
            response {
                status 200
                body('{"id":3,"name":"My Money Market","startingBalance":50,"currentBalance":6000,"isPrimary":false,"isInCashFlow":true,"type":{"id":4}}')
                headers {
                    contentType('application/json')
                }

            }
        },
        Contract.make {
            request {
                method 'GET'
                url '/v1/accounts/4'
            }
            response {
                status 200
                body('{"id":4,"name":"My Visa","startingBalance":50,"currentBalance":50.45,"isPrimary":false,"isInCashFlow":true,"type":{"id":8}}')
                headers {
                    contentType('application/json')
                }

            }
        },
        Contract.make {
            request {
                method 'GET'
                url '/v1/accounts/5'
            }
            response {
                status 200
                body('{"id":5,"name":"My Master Card","startingBalance":0,"currentBalance":2000.32,"isPrimary":false,"isInCashFlow":true,"type":{"id":8}}')
                headers {
                    contentType('application/json')
                }

            }
        },
        Contract.make {
            request {
                method 'GET'
                url '/v1/accounts/6'
            }
            response {
                status 200
                body('{"id":6,"name":"My Retirement","startingBalance":0,"currentBalance":1540,"isPrimary":false,"isInCashFlow":false,"type":{"id":6}}')
                headers {
                    contentType('application/json')
                }

            }
        }

]


