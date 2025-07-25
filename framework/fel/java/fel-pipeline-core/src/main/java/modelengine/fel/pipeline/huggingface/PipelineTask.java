/*---------------------------------------------------------------------------------------------
 *  Copyright (c) 2025 Huawei Technologies Co., Ltd. All rights reserved.
 *  This file is a part of the ModelEngine Project.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package modelengine.fel.pipeline.huggingface;

import static modelengine.fel.pipeline.huggingface.type.Constant.LIST_MEDIA_TYPE;

import lombok.Getter;
import modelengine.fel.pipeline.huggingface.asr.AsrInput;
import modelengine.fel.pipeline.huggingface.asr.AsrOutput;
import modelengine.fel.pipeline.huggingface.asr.AsrPipeline;
import modelengine.fel.pipeline.huggingface.img2img.Image2ImageInput;
import modelengine.fel.pipeline.huggingface.img2img.Image2ImagePipeline;
import modelengine.fel.pipeline.huggingface.text2img.Text2ImageInput;
import modelengine.fel.pipeline.huggingface.text2img.Text2ImagePipeline;
import modelengine.fel.pipeline.huggingface.tts.TtsInput;
import modelengine.fel.pipeline.huggingface.tts.TtsOutput;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 表示 huggingface pipeline 任务类型枚举。
 *
 * @author 易文渊
 * @since 2024-06-04
 */
@Getter
public enum PipelineTask {
    /**
     * 音频分类。
     */
    AUDIO_CLASSIFICATION("audio-classification", null, null),

    /**
     * 音频文本提取。
     *
     * @see AsrPipeline
     */
    AUTOMATIC_SPEECH_RECOGNITION("automatic-speech-recognition", AsrInput.class, AsrOutput.class),

    /**
     * 对话。
     */
    CONVERSATIONAL("conversational", null, null),

    /**
     * 深度估计。
     */
    DEPTH_ESTIMATION("depth-estimation", null, null),

    /**
     * 文档问答。
     */
    DOCUMENT_QUESTION_ANSWERING("document-question-answering", null, null),

    /**
     * 特征提取。
     */
    FEATURE_EXTRACTION("feature-extraction", null, null),

    /**
     * 填空。
     */
    FILL_MASK("fill-mask", null, null),

    /**
     * 图像分类。
     */
    IMAGE_CLASSIFICATION("image-classification", null, null),

    /**
     * 图像特征提取。
     */
    IMAGE_FEATURE_EXTRACTION("image-feature-extraction", null, null),

    /**
     * 图像分割。
     */
    IMAGE_SEGMENTATION("image-segmentation", null, null),

    /**
     * 图像到文本。
     */
    IMAGE_TO_TEXT("image-to-text", null, null),

    /**
     * 蒙版生成。
     */
    MASK_GENERATION("mask-generation", null, null),

    /**
     * 对象检测。
     */
    OBJECT_DETECTION("object-detection", null, null),

    /**
     * 问题回答。
     */
    QUESTION_ANSWERING("question-answering", null, null),

    /**
     * 句子对。
     */
    SUMMARIZATION("summarization", null, null),

    /**
     * 表格问题回答。
     */
    TABLE_QUESTION_ANSWERING("table-question-answering", null, null),

    /**
     * 文本生成。
     */
    TEXT2TEXT_GENERATION("text2text-generation", null, null),

    /**
     * 文本分类。
     */
    TEXT_CLASSIFICATION("text-classification", null, null),

    /**
     * 文本生成。
     */
    TEXT_GENERATION("text-generation", null, null),

    /**
     * 语音合成。
     *
     * @see Text2ImagePipeline
     */
    TEXT_TO_SPEECH("text-to-speech", TtsInput.class, TtsOutput.class),

    /**
     * 词法分析。
     */
    TOKEN_CLASSIFICATION("token-classification", null, null),

    /**
     * 翻译。
     */
    TRANSLATION("translation", null, null),

    /**
     * 翻译。
     */
    TRANSLATION_XX_TO_YY("translation_xx_to_yy", null, null),

    /**
     * 视频分类。
     */
    VIDEO_CLASSIFICATION("video-classification", null, null),

    /**
     * 视频分类。
     */
    VISUAL_QUESTION_ANSWERING("visual-question-answering", null, null),

    /**
     * 无标注分类。
     */
    ZERO_SHOT_CLASSIFICATION("zero-shot-classification", null, null),

    /**
     * 无标注图像分类。
     */
    ZERO_SHOT_IMAGE_CLASSIFICATION("zero-shot-image-classification", null, null),

    /**
     * 无标注音频分类。
     */
    ZERO_SHOT_AUDIO_CLASSIFICATION("zero-shot-audio-classification", null, null),

    /**
     * 无标注对象检测。
     */
    ZERO_SHOT_OBJECT_DETECTION("zero-shot-object-detection", null, null),

    /**
     * 图生图。
     *
     * @see Image2ImagePipeline
     */
    IMAGE_TO_IMAGE("image-to-image", Image2ImageInput.class, LIST_MEDIA_TYPE),

    /**
     * 文生图。
     *
     * @see Text2ImagePipeline
     */
    TEXT_TO_IMAGE("text-to-image", Text2ImageInput.class, LIST_MEDIA_TYPE);

    private final String id;
    private final Type inputType;
    private final Type outputType;

    private static final Map<String, PipelineTask> TASK_MAP =
            Arrays.stream(PipelineTask.values()).collect(Collectors.toMap(PipelineTask::getId, p -> p));

    /**
     * 根据任务名获取 {@link PipelineTask}。
     *
     * @param task 表示任务名的 {@link String}。
     * @return 表示流水线任务的 {@link PipelineTask}。
     */
    public static PipelineTask get(String task) {
        return TASK_MAP.get(task);
    }

    /**
     * 创建流水线任务枚举实例。
     *
     * @param id 表示任务编号的 {@link String}。
     * @param inputType 表示任务输入参数类型的 {@link Type}。
     * @param outputType 表示任务输出参数类型的 {@link Type}。
     */
    PipelineTask(String id, Type inputType, Type outputType) {
        this.id = id;
        this.inputType = inputType;
        this.outputType = outputType;
    }
}