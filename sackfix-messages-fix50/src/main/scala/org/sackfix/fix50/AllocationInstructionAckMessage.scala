package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class AllocationInstructionAckMessage(allocIDField:AllocIDField,
                                           partiesComponent:Option[PartiesComponent]=None,
                                           secondaryAllocIDField:Option[SecondaryAllocIDField]=None,
                                           tradeDateField:Option[TradeDateField]=None,
                                           transactTimeField:Option[TransactTimeField]=None,
                                           allocStatusField:AllocStatusField,
                                           allocRejCodeField:Option[AllocRejCodeField]=None,
                                           allocTypeField:Option[AllocTypeField]=None,
                                           allocIntermedReqTypeField:Option[AllocIntermedReqTypeField]=None,
                                           matchStatusField:Option[MatchStatusField]=None,
                                           productField:Option[ProductField]=None,
                                           securityTypeField:Option[SecurityTypeField]=None,
                                           textField:Option[TextField]=None,
                                           encodedTextLenField:Option[EncodedTextLenField]=None,
                                           encodedTextField:Option[EncodedTextField]=None,
                                           allocAckGrpComponent:Option[AllocAckGrpComponent]=None) extends SfFixMessageBody("P")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,allocIDField)
    partiesComponent.foreach(fmt(b,_))
    secondaryAllocIDField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    fmt(b,allocStatusField)
    allocRejCodeField.foreach(fmt(b,_))
    allocTypeField.foreach(fmt(b,_))
    allocIntermedReqTypeField.foreach(fmt(b,_))
    matchStatusField.foreach(fmt(b,_))
    productField.foreach(fmt(b,_))
    securityTypeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    allocAckGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object AllocationInstructionAckMessage extends SfFixMessageDecoder {
  val MsgType="P"
  val MsgName="AllocationInstructionAck"
             
  override val MandatoryFields = HashSet[Int](
    AllocIDField.TagId, AllocStatusField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || AllocAckGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecondaryAllocIDField.TagId, TradeDateField.TagId, TransactTimeField.TagId, AllocRejCodeField.TagId, AllocTypeField.TagId, 
    AllocIntermedReqTypeField.TagId, MatchStatusField.TagId, ProductField.TagId, SecurityTypeField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || AllocAckGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || AllocAckGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==AllocIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(AllocationInstructionAckMessage(AllocIDField.decode(myFields.get(AllocIDField.TagId)).get,
        PartiesComponent.decode(flds, startPos),
        myFields.get(SecondaryAllocIDField.TagId).flatMap(f=>SecondaryAllocIDField.decode(f)),
        myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        AllocStatusField.decode(myFields.get(AllocStatusField.TagId)).get,
        myFields.get(AllocRejCodeField.TagId).flatMap(f=>AllocRejCodeField.decode(f)),
        myFields.get(AllocTypeField.TagId).flatMap(f=>AllocTypeField.decode(f)),
        myFields.get(AllocIntermedReqTypeField.TagId).flatMap(f=>AllocIntermedReqTypeField.decode(f)),
        myFields.get(MatchStatusField.TagId).flatMap(f=>MatchStatusField.decode(f)),
        myFields.get(ProductField.TagId).flatMap(f=>ProductField.decode(f)),
        myFields.get(SecurityTypeField.TagId).flatMap(f=>SecurityTypeField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        AllocAckGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     