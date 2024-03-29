package com.github.codergate.utils;

import com.github.codergate.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PullRequestUtilTest {

    @InjectMocks
    private PullRequestUtil pullRequestUtil;

    private final int thresholdId = 1;
    private final int bugs = 10;
    private final int vulnerabilities = 5;
    private final double codeSmell = 0.7;
    private final double testCoverage = 0.9;
    private final double duplicatedLines = 0.5;
    private final double cyclomaticComplexity = 2.5;
    private final double documentedLines = 0.8;
    private final int cyclicDependency = 2;
    private final int godComponents = 1;
    private final int cycDependentMod = 3;
    private final int insufficientModularization = 1;
    private final int unnecessaryAbstraction = 2;
    private final int complexConditional = 4;
    private final int emptyCatchClause = 2;
    private final int missingAssertion = 3;
    private final int emptyTest = 1;
    private final double archSmellDensity = 0.2;
    private final double designSmellDensity = 0.3;
    private final double impSmellDensity = 0.1;
    private final boolean allowAction = false;
    private final int repositoryId = 1;
    private final String repositoryName = "example-repo";
    private final boolean fork = false;
    private final String installationId = "1234";
    private final long userId = 1L;
    private final String userName = "john_doe";
    private final String email = "john_doe@example.com";
    private final int id = 1;
    private final String type = "static";
    private final long timestamp = 1648825200;
    private final String branchUrl = "https://branchurl";
    ThresholdEntity thresholdEntity = new ThresholdEntity();
    AnalysisEntity analysisEntity = new AnalysisEntity();
    RepositoryEntity repositoryEntity = new RepositoryEntity();
    UserEntity userEntity = new UserEntity();
    BranchEntity branchEntity = new BranchEntity();
    BranchId branchId = new BranchId();
    @Before
    public void setUp(){
        userEntity.setUserId(userId);
        userEntity.setUserName(userName);
        userEntity.setEmail(email);
        repositoryEntity.setRepositoryId(repositoryId);
        repositoryEntity.setRepositoryName(repositoryName);
        repositoryEntity.setFork(fork);
        repositoryEntity.setInstallationId(installationId);
        repositoryEntity.setUserEntity(userEntity);
        thresholdEntity.setThresholdId(thresholdId);
        thresholdEntity.setRepositoryIdInThreshold(repositoryEntity);
        thresholdEntity.setBugs(bugs);
        thresholdEntity.setVulnerabilities(vulnerabilities);
        thresholdEntity.setCodeSmell(codeSmell);
        thresholdEntity.setTestCoverage(testCoverage);
        thresholdEntity.setDuplicatedLines(duplicatedLines);
        thresholdEntity.setCyclomaticComplexity(cyclomaticComplexity);
        thresholdEntity.setDocumentedLines(documentedLines);
        thresholdEntity.setCyclicDependency(cyclicDependency);
        thresholdEntity.setGodComponents(godComponents);
        thresholdEntity.setCycDependentMod(cycDependentMod);
        thresholdEntity.setInsufficientModularization(insufficientModularization);
        thresholdEntity.setUnnecessaryAbstraction(unnecessaryAbstraction);
        thresholdEntity.setComplexConditional(complexConditional);
        thresholdEntity.setEmptyCatchClause(emptyCatchClause);
        thresholdEntity.setMissingAssertion(missingAssertion);
        thresholdEntity.setEmptyTest(emptyTest);
        thresholdEntity.setArchSmellDensity(archSmellDensity);
        thresholdEntity.setImpSmellDensity(impSmellDensity);
        thresholdEntity.setDesignSmellDensity(designSmellDensity);
        thresholdEntity.setAllowAction(allowAction);
        branchId.setRepositoryId(repositoryId);
        branchId.setBranchUrl(branchUrl);
        branchEntity.setBranchId(branchId);
        branchEntity.setRepositoryIdInBranch(repositoryEntity);
        analysisEntity.setId(id);
        analysisEntity.setBugs(bugs);
        analysisEntity.setVulnerabilities(vulnerabilities);
        analysisEntity.setCodeSmell(codeSmell);
        analysisEntity.setTestCoverage(testCoverage);
        analysisEntity.setDuplicatedLines(duplicatedLines);
        analysisEntity.setCyclomaticComplexity(cyclomaticComplexity);
        analysisEntity.setDocumentedLines(documentedLines);
        analysisEntity.setCyclicDependency(cyclicDependency);
        analysisEntity.setGodComponents(godComponents);
        analysisEntity.setCyclicallyDependentModularization(cycDependentMod);
        analysisEntity.setInsufficientModularization(insufficientModularization);
        analysisEntity.setUnnecessaryAbstraction(unnecessaryAbstraction);
        analysisEntity.setComplexConditional(complexConditional);
        analysisEntity.setEmptyCatchClause(emptyCatchClause);
        analysisEntity.setMissingAssertion(missingAssertion);
        analysisEntity.setEmptyTest(emptyTest);
        analysisEntity.setArchSmellDensity(archSmellDensity);
        analysisEntity.setImpSmellDensity(impSmellDensity);
        analysisEntity.setDesignSmellDensity(designSmellDensity);
        analysisEntity.setBranchId(branchEntity);
    }

    @Test
    public void testGetFalseThresholdKeys_MultipleValuesAboveThreshold() {
        List<String> falseKeys = pullRequestUtil.getFalseThresholdKeys(analysisEntity, thresholdEntity);
        assertEquals(falseKeys.size(), 15);
    }


    @Test
    public void testGetFalseThresholdKeys_MultipleValuesBelowThreshold() {
        List<String> falseKeys = pullRequestUtil.getFalseThresholdKeys(new AnalysisEntity(), thresholdEntity);
        assertEquals(falseKeys.size(), 0);
    }

}


