package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class MarketDefinitionMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                   marketReportIDField:MarketReportIDField,
                                   marketReqIDField:Option[MarketReqIDField]=None,
                                   marketIDField:MarketIDField,
                                   marketSegmentIDField:Option[MarketSegmentIDField]=None,
                                   marketSegmentDescField:Option[MarketSegmentDescField]=None,
                                   encodedMktSegmDescLenField:Option[EncodedMktSegmDescLenField]=None,
                                   encodedMktSegmDescField:Option[EncodedMktSegmDescField]=None,
                                   parentMktSegmIDField:Option[ParentMktSegmIDField]=None,
                                   currencyField:Option[CurrencyField]=None,
                                   baseTradingRulesComponent:Option[BaseTradingRulesComponent]=None,
                                   ordTypeRulesComponent:Option[OrdTypeRulesComponent]=None,
                                   timeInForceRulesComponent:Option[TimeInForceRulesComponent]=None,
                                   execInstRulesComponent:Option[ExecInstRulesComponent]=None,
                                   transactTimeField:Option[TransactTimeField]=None,
                                   textField:Option[TextField]=None,
                                   encodedTextLenField:Option[EncodedTextLenField]=None,
                                   encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("BU")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    fmt(b,marketReportIDField)
    marketReqIDField.foreach(fmt(b,_))
    fmt(b,marketIDField)
    marketSegmentIDField.foreach(fmt(b,_))
    marketSegmentDescField.foreach(fmt(b,_))
    encodedMktSegmDescLenField.foreach(fmt(b,_))
    encodedMktSegmDescField.foreach(fmt(b,_))
    parentMktSegmIDField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    baseTradingRulesComponent.foreach(fmt(b,_))
    ordTypeRulesComponent.foreach(fmt(b,_))
    timeInForceRulesComponent.foreach(fmt(b,_))
    execInstRulesComponent.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object MarketDefinitionMessage extends SfFixMessageDecoder {
  val MsgType="BU"
  val MsgName="MarketDefinition"
             
  override val MandatoryFields = HashSet[Int](
    MarketReportIDField.TagId, MarketIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || BaseTradingRulesComponent.isMandatoryField(tagId) || OrdTypeRulesComponent.isMandatoryField(tagId) || TimeInForceRulesComponent.isMandatoryField(tagId) || 
    ExecInstRulesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MarketReqIDField.TagId, MarketSegmentIDField.TagId, MarketSegmentDescField.TagId, EncodedMktSegmDescLenField.TagId, EncodedMktSegmDescField.TagId, 
    ParentMktSegmIDField.TagId, CurrencyField.TagId, TransactTimeField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || BaseTradingRulesComponent.isOptionalField(tagId) || OrdTypeRulesComponent.isOptionalField(tagId) || TimeInForceRulesComponent.isOptionalField(tagId) || 
    ExecInstRulesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || BaseTradingRulesComponent.isFieldOf(tagId) || OrdTypeRulesComponent.isFieldOf(tagId) || 
    TimeInForceRulesComponent.isFieldOf(tagId) || ExecInstRulesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MarketDefinitionMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        MarketReportIDField.decode(myFields.get(MarketReportIDField.TagId)).get,
        myFields.get(MarketReqIDField.TagId).flatMap(f=>MarketReqIDField.decode(f)),
        MarketIDField.decode(myFields.get(MarketIDField.TagId)).get,
        myFields.get(MarketSegmentIDField.TagId).flatMap(f=>MarketSegmentIDField.decode(f)),
        myFields.get(MarketSegmentDescField.TagId).flatMap(f=>MarketSegmentDescField.decode(f)),
        myFields.get(EncodedMktSegmDescLenField.TagId).flatMap(f=>EncodedMktSegmDescLenField.decode(f)),
        myFields.get(EncodedMktSegmDescField.TagId).flatMap(f=>EncodedMktSegmDescField.decode(f)),
        myFields.get(ParentMktSegmIDField.TagId).flatMap(f=>ParentMktSegmIDField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        BaseTradingRulesComponent.decode(flds, startPos),
        OrdTypeRulesComponent.decode(flds, startPos),
        TimeInForceRulesComponent.decode(flds, startPos),
        ExecInstRulesComponent.decode(flds, startPos),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     